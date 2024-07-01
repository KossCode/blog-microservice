# Installation Instructions
## Prerequisites
Ensure you have the following tools installed:

* Helm
* Minikube or Kubernetes CLI (kubectl)
* Docker

## Installation Steps
### Local Minikube Cluster
Please run the following command in you console
* `minikube start` : Start your Minikube cluster.
* `cd ./my-chart` : Navigate to the project directory.
* `helm package ./` : Package the Helm chart.
* `helm install my-release ./` : Install the Helm release.

## AWS or DigitalOcean Deployment
### For AWS:

* `aws configure` : Configure AWS CLI.
* `eksctl create cluster --name your-cluster-name --region your-region` : Create EKS cluster.
* `aws eks --region your-region update-kubeconfig --name your-cluster-name` : Update kubeconfig for AWS.

### For DigitalOcean:
* `doctl auth init` : Initialize DigitalOcean CLI.
* `doctl kubernetes cluster create your-cluster-name --region your-region` : Create DigitalOcean Kubernetes cluster.
* `doctl kubernetes cluster kubeconfig save your-cluster-name` : Save kubeconfig for DigitalOcean.


### And same as for local deployment
* `cd ./my-chart` : Navigate to the project directory.
* `helm package .` : Package the Helm chart.
* `helm install my-release .` : Install the Helm release.

## Verifying the Installation
* `kubectl get pods` : Check available pods.
* `kubectl get svc` : Check available services.
* `kubectl get deploy` : Check running deployments.

## Uninstallation
To uninstall all the services and deployments, run:

* `helm uninstall my-release` : Uninstall the Helm release.

## Conclusion
By following these instructions, you can deploy your Java Spring application using Helm on either a local Minikube cluster or cloud providers such as AWS and DigitalOcean. If you encounter any issues, ensure that all prerequisites are met and configurations are correctly set up.