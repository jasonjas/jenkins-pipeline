#!/usr/bin/env/groovy

// pipelineJobs = ["dsl-job-1", "dsl-job-2", "dsl-job-3"]

pipelineJobs = [
  [ name: "dsl-job-1",
   branch: "master",
   location: "ci/asdfadsf.groovy"
   ],
  [ name: "dsl-job-2",
   branch: "master",
   location: "ci/asdfadsf.groovy"
   ],
  [ name: "dsl-job-3",
   branch: "master",
   location: "ci/asdfadsf.groovy"
   ]
  ]

pipelineJobs.each { it ->
  branch = it.branch
  location = it.location
  pipelineJob(it.name) {
    parameters {
          choiceParam('env', ['sandbox'], 'environment to run against')
          stringParam('customDockerTag', '',
              'a custom broker-backend docker container to use. leave blank to use env default')
          stringParam('RESULTS_BUCKET', 'dti-usaspending-test-results-nonprod',
              'the bucket that will store the metrics for this run')
          booleanParam('notifyMe', false, 'Tag the user running this job in slack notification')
      }
    logRotator {
        daysToKeep(90)
    }
    location.matches("a")
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("google.com")
                        credentials("abcd")
                    }
                    branch(branch)
                }
            }
            scriptPath(location)
            lightweight()
        }
    }
  }
}
