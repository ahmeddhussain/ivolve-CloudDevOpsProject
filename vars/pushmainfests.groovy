def call(String gitCredentialsId, String commitMessage) {
    echo "Pushing updated Kubernetes manifests to Git repository..."
    withCredentials([usernamePassword(credentialsId: gitCredentialsId, passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
        sh """
            git config user.email "jenkins@ivolve.com"
            git config user.name "Jenkins CI"
            git add k8s/
            git commit -m "${commitMessage}" || echo "No changes to commit"
            git push https://${GIT_USERNAME}:${GIT_PASSWORD}@https://github.com/ahmeddhussain/ivolve-CloudDevOpsProject.git HEAD:main
        """
    }
}