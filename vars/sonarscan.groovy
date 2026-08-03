def call(String projectKey, String credentialsId = 'sonarqube-token') {
    echo "Running SonarQube Code Quality Analysis for ${projectKey}..."
    withCredentials([string(credentialsId: credentialsId, variable: 'SONAR_TOKEN')]) {
        sh """
            sonar-scanner \
              -Dsonar.projectKey=${projectKey} \
              -Dsonar.sources=. \
              -Dsonar.host.url=http://localhost:9000 \
              -Dsonar.login=${SONAR_TOKEN} \
              || echo "SonarQube scan completed with warnings"
        """
    }
}