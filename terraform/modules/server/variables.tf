variable "vpc_id" { 
  type        = string 
  description = "The VPC ID where the server will be launched"
}

variable "public_subnet" { 
  type        = string 
  description = "The public subnet ID for the Jenkins instance"
}

variable "my_ip" { 
  type        = string 
  description = "Your IP address for SSH access"
}

variable "key_name" { 
  type        = string 
  description = "The AWS key pair name for SSH access"
}

variable "jenkins_instance_type" { 
  type        = string 
  description = "EC2 instance size"
}