output "jenkins_public_ip" {
  value       = aws_instance.jenkins.public_ip
  description = "The public IP address of the Jenkins EC2 instance"
}

output "jenkins_security_group_id" {
  value       = aws_security_group.jenkins_sg.id
  description = "The Security Group ID assigned to Jenkins"
}