import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SpringButton(
    onClick: () -> Unit,
    text: String,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    var pressed by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.9f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "spring-scale"
    )

    Button(
        onClick = {
            pressed = true
            onClick()
            coroutineScope.launch {
                delay(100)
                pressed = false
            }
        },
        modifier = modifier
            .scale(scale)
            .width(width)
            .height(height),
        colors = colors
    ) {
        Text(text)
    }
}

