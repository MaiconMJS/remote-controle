# 📱 Aplicativo Android de Controle Remoto

Aplicativo desenvolvido em Kotlin para controle remoto do quadrado na aplicação web via protocolo UDP.

## 🎨 Telas do Sistema

| Controle Mobile                                                | Visualização Web                                                |
| -------------------------------------------------------------- | --------------------------------------------------------------- |
| <img src="tela.jpg" alt="Interface do App Mobile" width="300"> | <img src="square.png" alt="Quadro de Controle Web" width="600"> |

## 🛠 Stack Tecnológico

### Linguagem e Frameworks

- **Kotlin** - Linguagem principal
- **Jetpack Compose** - UI declarativa
- **Ktor Network** - Comunicação UDP
- **Material Design 3** - Design system

### Dependências Principais

```kotlin
dependencies {
    implementation("io.ktor:ktor-network:2.3.5")
    implementation("androidx.compose.material3:material3:1.1.2")
    // ... outras dependências
}
```
