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

def a="https://google.com"

try {
node('master') {
stage ('Stage 1') {
    echo "BUILD_URL=${env.BUILD_URL}"
 
    def workspace = pwd()
    echo "workspace=${workspace}"
    echo "stage 1 current result: ${currentBuild.currentResult}"
    echo "stage 1 result: ${currentBuild.result}"
    deleteDir()
    dir('test') {
            git changelog: false, poll: false, url: 'https://github.com/jasonjas/jenkins-pipeline'
    }
} // stage
stage ('Stage 2') {
    hidden = credentials("hello there")
    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            echo "${hidden}"
    }
}
stage ('stage 3') {
	sh "curl -k ${a} > a.txt"
}
stage ('stage 4') {
    sh '''
	echo hello there this is the hidden var - \$a - that was it
    '''
    sh 'echo hello \$hidden \$a'
    echo 'value hidden: ${hidden}, value hidden: \$hidden'
    echo "Stage 2 current result: ${currentBuild.currentResult}"
    echo "Stage 2 result: ${currentBuild.result}"
    sh "echo environment vars: ${env}"
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
