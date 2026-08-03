def call(String awsRegion, String ecrUrl, String imageName, String imageTag) {
    echo "Logging into AWS ECR and pushing ${imageName}:${imageTag}..."
    sh """
        aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrUrl}
        docker tag ${imageName}:${imageTag} ${ecrUrl}/${imageName}:${imageTag}
        docker push ${ecrUrl}/${imageName}:${imageTag}
    """
}