#!/usr/bin/env groovy
 
/**
        * Sample Jenkinsfile for Jenkins2 Pipeline
        * from https://github.com/hotwilson/jenkins2/edit/master/Jenkinsfile
        * by wilsonmar@gmail.com 
 */
 
import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import java.net.URL

try {
node('master') {
stage ('Stage 1') {
	echo "BUILD_URL=${env.BUILD_URL}"
 
	def workspace = pwd()
	echo "workspace=${workspace}"
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh "exit 1"
        }
        echo "stage 1 current result: ${currentBuild.currentResult}"
        echo "stage 1 result: ${currentBuild.result}"
} // stage
stage ('Stage 2') {
        hidden = credentials("hello there")
        echo hidden
        sh 'echo hello \$hidden'
        echo "Stage 2 current result: ${currentBuild.currentResult}"
        echo "Stage 2 result: ${currentBuild.result}"
}

} // node
} // try end
catch (exc) {
        currentBuild.result = 'FAILURE'
} finally {
 echo "finished"
 echo "final result: ${currentBuild.result}"
 echo "final current result: ${currentBuild.currentResult}"
}
