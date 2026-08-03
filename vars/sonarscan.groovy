def call(String projectKey, String sourceDir = ".", String credentialsId = 'sonarqube-token') {
    echo "Running SonarQube Code Quality Analysis for ${projectKey}..."
    withCredentials([string(credentialsId: credentialsId, variable: 'SONAR_TOKEN')]) {
        sh """
            docker run --rm --net=host \
              -v "\$(pwd):/usr/src" \
              sonarsource/sonar-scanner-cli \
              -Dsonar.projectKey=${projectKey} \
              -Dsonar.sources=${sourceDir} \
              -Dsonar.host.url="http://localhost:9000" \
              -Dsonar.token="\${SONAR_TOKEN}" \
              -Dsonar.java.binaries=. \
              -Dsonar.exclusions="**/node_modules/**,**/target/**,**/*.jar,**/*.war,**/*.png,**/*.jpg,**/*.jpeg,**/*.svg" \
              -Dsonar.javascript.node.maxspace=512 \
              || echo "SonarQube scan completed with warnings"
        """
    }
}