def call(String ecrUrl, String imageName, String imageTag) {
    echo "Cleaning up local images to free disk space..."
    sh """
        docker rmi ${imageName}:${imageTag} || true
        docker rmi ${ecrUrl}/${imageName}:${imageTag} || true
    """
}