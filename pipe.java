pipeline {
    agent any
    stages{
      stages('One') {
            steps {
                echo 'Hi this is paras'
                }
            }
        stage('Two'){
            
              steps {
                      input('Do you want to proceed')
                }
                    }
                 stage('Three') {
                        when {
                              not {
                                      branch "master"
                                    }
                                  }
                                steps {
                                      echo "hello"
                                      }
                        }
                        stage('four') {
                                    parallel {
                                    stage('Unit Test') {
                                            steps{
                                                echo "Running the unit test...."
                                              }
                                          }
                                          stage('Integration test') {
                                          agent {
                                                docker {
                                                    reuseNode  false
                                                    image 'ubuntu'
                                                    }
                                              }
                                                    step {
                                                      echo 'Running the integration testr...'
                                                      }
                                                }  }
                              }
                   }
        }
                                              
