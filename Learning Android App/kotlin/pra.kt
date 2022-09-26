

class dataModel {
    var repoName: String
        get() = repoName
    var repoUrl: String
        get() = repoUrl
    var repoDescrption: String
        get() = repoDescrption

    constructor(repoName: String, repoUrl: String, repoDescrption: String) {
        this.repoName = repoName
        this.repoUrl = repoUrl
        this.repoDescrption = repoDescrption
    }
}

fun main(args: Array<String>) {
    var temp = dataModel("a","b","c");

    println(${temp.get})
}