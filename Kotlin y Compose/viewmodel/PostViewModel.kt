class PostViewModel : ViewModel() {
    var posts by mutableStateOf<List<Post>>(emptyList())
    var isLoading by mutableStateOf(false)

    fun fetchPosts() {
        viewModelScope.launch {
            isLoading = true
            try {
                posts = apiService.getPosts()
            } catch (e: Exception) {
                // Manejo de errores
            }
            isLoading = false
        }
    }
}
