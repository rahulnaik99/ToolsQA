pipeline {
    agent any

    environment {
        EVIDENCE_DIR = "${WORKSPACE}\\ToolsQA\\TestEvidences"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning or pulling repository..."
                bat '''
                if not exist ToolsQA (
                    git clone https://github.com/rahulnaik99/ToolsQA.git
                ) else (
                    cd ToolsQA
                    git pull
                )
                '''
            }
        }

        stage('Build') {
            steps {
                echo "Building the project (skip tests)..."
                bat 'cd ToolsQA && mvn clean compile -DskipTests'
            }
        }

        stage('Run Parallel Tests') {
            parallel {
                stage('Suite Part 1') {
                    steps {
                        echo "Running first part of TestNG suite..."
                        bat 'cd ToolsQA && mvn test -DsuiteXmlFile=testng.xml -Dtestng.threadCount=3'
                    }
                }
                stage('Suite Part 2') {
                    steps {
                        echo "Running second part of TestNG suite..."
                        bat 'cd ToolsQA && mvn test -DsuiteXmlFile=testng.xml -Dtestng.threadCount=3'
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Archiving Test Evidence..."
            archiveArtifacts artifacts: 'ToolsQA\\TestEvidences\\**', allowEmptyArchive: true

            echo "Publishing TestNG/Surefire reports..."
            junit 'ToolsQA\\target\\surefire-reports\\*.xml'
        }

        success {
            echo "Tests completed successfully!"
        }

        failure {
            echo "Some tests failed. Check reports and PPT files."
        }
    }
}
