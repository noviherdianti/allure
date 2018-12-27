var express = require('express');
var router = express.Router();
var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;

/* GET users listing. */
router.get('/', function(req, res, next) {
  var project = req.query.project;
  var release = req.query.release;
  // Connect to the db
  MongoClient.connect("mongodb://172.17.11.104:27017/extent", function(err, db) {
    if(!err) {
      var collection = db.collection('project');
      collection.find({'name':project}).limit(1).toArray(function(err, projectList){
          var projectId = new ObjectID(projectList[0]._id);
          collection = db.collection('report');
          collection.find({"project" : projectId, "fileName" : release}).toArray(function(err, report){
            var reportList = [];
            var response = {};
            for(var a=0; a < report.length; a++){
                var reportId = report[a]._id;
                reportList.push(reportId);
            }
            collection = db.collection('test');
            var query = [
              {$match:{$and:[{"report" : {$in :reportList}}]}},{$group:{"_id":"$status", total:{$sum:1}}}
            ]
            collection.aggregate(query).toArray(function(err, results){
                var defaultStatus = ["pass", "fail", "warning", "skip"];
                for(var b=0; b < results.length; b++){
                    var result = results[b];
                    var status = result._id;
                    var index = defaultStatus.indexOf(status);
                    response[status] = result.total;
                    defaultStatus.splice(index,1);
                }

                for(var c=0; c<defaultStatus.length; c++){
                  response[defaultStatus[c]] = 0;
                }
                collection.find({"report" : {$in :reportList}}).project({"_id": 0, "name":1, "description":1, "status":1}).sort({"name":1}).toArray(function(err, detail){
                  res.send({"resultTotal":response, "detail": detail});
                })
            })
          });

      });
    }
  });
});

module.exports = router;
