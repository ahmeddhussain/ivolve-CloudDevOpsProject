def call(String awsRegion, String ecrUrl, String imageName, String imageTag) {
    echo "Logging into AWS ECR and pushing ${imageName}:${imageTag}..."
    withCredentials([
        string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'),
        string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
    ]) {
        sh """
            aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrUrl}
            docker tag ${imageName}:${imageTag} ${ecrUrl}/${imageName}:${imageTag}
            docker push ${ecrUrl}/${imageName}:${imageTag}
        """
    }
}