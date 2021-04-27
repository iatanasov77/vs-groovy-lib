
////////////////////////////////////////////////////
// https://gist.github.com/eeichinger/9761870
////////////////////////////////////////////////////
def getGitTags( String repo ) {
    def gettags = ( "git ls-remote -t -h ${repo} refs/tags/*" ).execute()

    return gettags.text.readLines().collect { it.split()[1].replaceAll( 'refs/tags/', '' )  }.unique()
}
