output "jenkins_public_ip" {
  value = module.server.jenkins_public_ip
}
output "eks_cluster_name" {
  value = module.eks.cluster_name
}
output "ecr_frontend_url" {
  value = module.ecr.frontend_repo_url
}
output "ecr_auth_url" {
  value = module.ecr.auth_repo_url
}
output "ecr_roadmap_url" {
  value = module.ecr.roadmap_repo_url
}