import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun SpringPressReleaseButton(
    text: String,
    onPress: () -> Unit,
    onRelease: () -> Unit,
    width: Dp = 120.dp,
    height: Dp = 80.dp,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    var pressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.9f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "spring-press-scale"
    )

    Button(
        onClick = {}, // onClick vazio para evitar conflito com press/release
        modifier = modifier
            .scale(scale)
            .width(width)
            .height(height)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        pressed = true
                        onPress()
                        true
                    }

                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        pressed = false
                        onRelease()
                        true
                    }
                    else -> false
                }
            },
        colors = colors
    ) {
        Text(text)
    }
}
