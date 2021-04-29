
////////////////////////////////////////////////////
// https://gist.github.com/eeichinger/9761870
////////////////////////////////////////////////////
def getGitTags( String repo ) {
    def gettags = ( "git ls-remote -t -h ${repo} refs/tags/*" ).execute()
    def tags    = gettags.text.readLines().collect { it.split()[1].replaceAll( 'refs/tags/', '' )  }.unique()

    tags.removeAll { it.contains( '^{}' ) }
    return tags.reverse()
}

def getGitBranches( String repo ) {
    def getbranches = ( "git ls-remote --heads -h ${repo} refs/heads/*" ).execute()
    def branches    = getbranches.text.readLines().collect { it.split()[1].replaceAll( 'refs/heads/', '' )  }.unique()

    return branches
}
