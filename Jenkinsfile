pipeline {
    agent any

    tools {
        // assuming you're using Maven
        maven 'MAVEN_HOME'  
        // or specify the Maven installation name configured on Jenkins
    }

    environment {
        // Directory where you save PPTs / screenshots
        EVIDENCE_DIR = "${WORKSPACE}/TestEvidences"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your GitHub repo
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Clean & compile, skip tests for this phase
                sh "mvn clean compile -DskipTests"
            }
        }

        stage('Run Parallel Tests') {
            // Run your TestNG suite in parallel; adjust number of splits / groups as needed
            parallel {
                stage('Suite Part 1') {
                    steps {
                        // Use a custom TestNG suite or subset
                        sh "mvn test -DsuiteXmlFile=testng.xml -Dtestng.threadCount=3"
                    }
                }
                stage('Suite Part 2') {
                    steps {
                        // You can run the same suite again but split it differently via maven/fork or groups
                        sh "mvn test -DsuiteXmlFile=testng.xml -Dtestng.threadCount=3"
                    }
                }
                // Add more parallel stages if required
            }
        }
    }

    post {
        always {
            // Archive the Test Evidence: PPTs, screenshots
            archiveArtifacts artifacts: 'TestEvidences/**', allowEmptyArchive: true

            // Publish TestNG results
            junit '**/target/surefire-reports/*.xml'
            // Alternatively, if you are using TestNG reports plugin:
            // testNG reportFilenamePattern: '**/test-output/testng-results.xml'
        }

        success {
            echo "Tests completed successfully."
        }

        failure {
            echo "There were test failures."
        }
    }
}
