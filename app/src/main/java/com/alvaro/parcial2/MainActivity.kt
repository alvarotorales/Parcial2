import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormularioProducto() {

    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var precio by remember { mutableStateOf(TextFieldValue("")) }
    var marca by remember { mutableStateOf(TextFieldValue("")) }
    var existencia by remember { mutableStateOf(TextFieldValue("")) }
        var categoriaSeleccionada by remember { mutableStateOf("Electrónica") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del producto") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = existencia,
            onValueChange = { existencia = it },
            label = { Text("Existencia") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Categoría")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RadioButton(
                selected = categoriaSeleccionada == "Electrónica",
                onClick = { categoriaSeleccionada = "Electrónica" }
            )
            Text("Electrónica")

            RadioButton(
                selected = categoriaSeleccionada == "Ropa",
                onClick = { categoriaSeleccionada = "Ropa" }
            )
            Text("Ropa")

            RadioButton(
                selected = categoriaSeleccionada == "Alimentos",
                onClick = { categoriaSeleccionada = "Alimentos" }
            )
            Text("Alimentos")
        }


        Button(
            onClick = {
                nombre = TextFieldValue("")
                precio = TextFieldValue("")
                marca = TextFieldValue("")
                existencia = TextFieldValue("")
                categoriaSeleccionada = "Electrónica"
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioProductoPreview() {
    FormularioProducto()
}