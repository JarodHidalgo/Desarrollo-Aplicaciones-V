@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Estrella",
                tint = Color.Yellow
            )
            Text(text = "Hola, $name!", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MiPrimeraAppTheme {
        Greeting("Mundo")
    }
}



data class Item(val title: String, val description: String)

val sampleItems = listOf(
    Item("Título 1", "Descripción 1"),
    Item("Título 2", "Descripción 2"),
    // Agrega más
)



@Composable
fun ItemList(items: List<Item>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { item ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


val viewModel: PostViewModel = viewModel()
LaunchedEffect(Unit) { viewModel.fetchPosts() }

if (viewModel.isLoading) {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize().wrapContentSize())
} else {
    ItemList(viewModel.posts.map { Item(it.title, it.body) })
}