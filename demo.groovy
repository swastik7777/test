@Library('shared-library') _

        //## Please provide docker build arguments if applicable in the fashion --> "key1=value1, key2=value2"
        def (ecrRepoURL, repoName, region, ecrCredsInJenkins, dockerFilePath, dockerBuildContent, dockerBuildArguments) = [
        
        env.ecrRepoURL,
        "console",
        env.region,
        "prod-jenkins-ecr-creds",
        "Dockerfile",
        "."
        ]
        def (gitCredentialsId, devOpsScmUrl, devOpsScmBranchName, subDirectoryToCheckoutTo) = [
                env.gitlab_creds,
                env.devOpsScmUrl,
                env.devOpsScmBranchName,
                "devOpsRepo"
            ]

        def (chart_version, aws_creds, aus_cluster_name, aus_cluster_region, us_cluster_name, us_cluster_region) = [
            "1.0.0",
            "prod-aws-jenkins-creds",
            env.production_aus_cluster_name,
            env.us_cluster_region,
            env.staging_us_cluster_name,
            env.us_cluster_region,
            env.region
        ]

runpipeline.runDockerBuildPipeline(ecrRepoURL, repoName, region, ecrCredsInJenkins, dockerFilePath,
                              dockerBuildContent, dockerBuildArguments, imageTag,
                              scmUrl, branchName, gitCredentialsId) {
}
