def call(String manifestPath, String imageName, String imageTag, String ecrUrl) {
    echo "Updating Kubernetes Manifest ${manifestPath} with image tag ${imageTag}..."
    sh """
        sed -i 's|image: .*|image: ${ecrUrl}/${imageName}:${imageTag}|g' ${manifestPath}
    """
}