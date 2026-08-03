module "network" {
  source               = "./modules/network"
  vpc_cidr             = var.vpc_cidr
  vpc_name             = var.vpc_name
  public_subnet_cidrs  = var.public_subnet_cidrs
  private_subnet_cidrs = var.private_subnet_cidrs
}

module "server" {
  source                = "./modules/server"
  vpc_id                = module.network.vpc_id
  public_subnet         = module.network.public_subnets[0]
  my_ip                 = var.my_ip
  key_name              = var.key_name
  jenkins_instance_type = var.jenkins_instance_type
}

module "eks" {
  source              = "./modules/eks"
  cluster_name        = var.cluster_name
  vpc_id              = module.network.vpc_id
  private_subnets     = module.network.private_subnets
  node_group_name     = var.node_group_name
  node_instance_types = var.node_instance_types
  node_desired_size   = var.node_desired_size
  node_min_size       = var.node_min_size
  node_max_size       = var.node_max_size
}

module "ecr" {
  source            = "./modules/ecr"
  ecr_frontend_repo = var.ecr_frontend_repo
  ecr_auth_repo  = var.ecr_auth_repo
  ecr_roadmap_repo      = var.ecr_roadmap_repo
}

