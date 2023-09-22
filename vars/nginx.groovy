def call() {
  pipeline {
    agent { label 'slave' }
    
    stages {
        stage('Install Nginx') {
            steps {
                sh 'sudo apt-get update'
                sh 'sudo apt-get install -y nginx'
            }
        }
    }
    
    post {
        always {
            script {
                // Display the Nginx version after installation
                sh 'nginx -v'
            }
        }
    }
  }
}  
