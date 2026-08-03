terraform {
  backend "s3" {
    bucket         = "ivovle-final-project" 
    key            = "terraform.tfstate"
    region         = "us-east-1"
    encrypt      = true
    use_lockfile = true
  }
}