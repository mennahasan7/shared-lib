def {
 pipeline {
    agent { label 'slave' }
    
    stages {
        stage('Install Nginx') {
            steps {
                sh 'apt-get update'
                sh 'apt-get install -y nginx'
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
