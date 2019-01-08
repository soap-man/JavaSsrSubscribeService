workflow "New workflow" {
  on = "push"
  resolves = ["GitHub Action for Google Cloud"]
}

action "GitHub Action for Google Cloud" {
  uses = "actions/gcloud/cli@8ec8bfad3853155b42cea5eb9f8395b098111228"
  runs = "test"
  args = "sudo su"
}
