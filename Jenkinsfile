pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    git 'https://github.com/your-username/your-repo.git' // Replace with your repo URL
                }
            }
            stage('Build and Test') {
                steps {
                    sh 'mvn clean install' // Or 'mvn clean test'
                }
            }
            stage('Cucumber Reports') {
                steps {
                    // Post-build action for Cucumber reports (requires Cucumber Reports plugin)
                    cucumber 'target/cucumber-reports/*.json' // Adjust path as needed
                }
            }
        }
    }
