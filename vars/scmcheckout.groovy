def call(Map config = [:]) {
    def repoUrl = config.repoUrl ?: error("Git repo URL not provided")
    def branch = config.branch ?: 'main'

    stage("Checkout Code") {
        git branch: branch, url: repoUrl
    }
}
