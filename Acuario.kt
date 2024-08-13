package Acuario
import kotlin.math.PI
// Clase base Acuario
open class Acuario(open var largo: Int = 100, open var ancho: Int = 20, open var alto: Int = 40) {
    open var volumen: Int
        get() = (ancho * alto * largo) / 1000 // 1000 cm^3 = 1 l
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }
    open val forma: String = "rectángulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9 // 90% del volumen
    init {
        println("Inicializando acuario")
    }
    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm, Largo: $largo cm, Alto: $alto cm")
        println("Volumen: $volumen l, Agua: $agua l (${agua / volumen * 100.0}% lleno)")
    }
}
// Subclase TanqueTorre
class TanqueTorre(override var alto: Int, var diametro: Int) : Acuario(largo = diametro, ancho = diametro, alto = alto) {
    override var volumen: Int
        get() = (ancho / 2 * largo / 2 * alto / 1000 * PI).toInt() // Volumen cilíndrico
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho / 2 * largo / 2)).toInt()
        }
    override var agua: Double
        get() = volumen * 0.8 // 80% del volumen
        set(value) {
            // No se necesita un setter para agua, ya que se calcula
        }
    override val forma: String = "cilindro"
}
fun construirAcuario() {
    val miAcuario = Acuario(ancho = 25, largo = 25, alto = 40)
    miAcuario.imprimirTamano()

    // Crear un TanqueTorre con diámetro de 25 cm y altura de 40 cm
    val miTorre = TanqueTorre(diametro = 25, alto = 45)
    miTorre.imprimirTamano()
}
fun main() {
    construirAcuario()
}