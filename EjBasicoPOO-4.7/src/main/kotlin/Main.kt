/**  VERSION 1 ANTES DE CAMBIO ENUNCIADO
 * Ejercicio 4.7¶
 *  * Se quiere crear una clase Cuenta la cual se caracteriza por tener asociado un número de cuenta y un saldo disponible.
 *  *
 *  * Además, se puede consultar el saldo disponible, recibir abonos y realizar pagos.
 *  *
 *  * Crear también una clase Persona, que se caracteriza por un DNI y una lista de cuentas bancarias.
 *  *
 *  * La Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita añadir cuentas (hasta 3 el máximo permitido).
 *  *
 *  * También debe contener un método que devuelva si la persona es morosa (si tienen alguna cuenta con saldo negativo).
 *  *
 *  * En el programa principal, instanciar un objeto Persona con un DNI cualquiera, así como dos objetos cuenta, una sin saldo inicial y otra con 700 euros. La persona recibe la nómina mensual, por lo que ingresa 1100 euros en la primera cuenta, pero tiene que pagar el alquiler de 750 euros con la segunda. Imprimir por pantalla si la persona es morosa.
 *  *
 *  * Posteriormente hacer una transferencia de una cuenta a otra (de forma que todos los saldos sean positivos) y mostrar por pantalla el estado de la persona.



class Cuenta(val numCuenta: Int, var saldoDispo: Double){


fun consultarSaldo(): Double{
return this.saldoDispo
}

fun recibirAbono(cantidad: Double){
println("Has recibido billetes: ${cantidad}€")
this.saldoDispo += cantidad
}

fun realizarPago(cantidad: Double){
this.saldoDispo -= cantidad
println("Has pagado: ${cantidad}€")
}
}

class PersonaEj7(val dni: Int, var listaCuentas: MutableList<Cuenta>){
fun aniadirCuenta(cuenta: Cuenta){
if (this.listaCuentas.size < 3){
this.listaCuentas.add(cuenta)
}
else{
print("Error - Limite de cuentas alcanzado (3)")
}
}

fun comprobarMorosidad(): Boolean{
for (cuenta in this.listaCuentas){
if (cuenta.saldoDispo < 0 ){
return true
}
}
return false
}
}
 */



// VERSION ACTUAL TRAS CAMBIO ENUNCIADO
/**
 * Ejercicio 4.7¶
 * Se quiere crear una clase Cuenta la cual se caracteriza por tener asociado un número de cuenta y un saldo disponible.
 *
 * Además, se puede consultar el saldo disponible, recibir abonos y realizar pagos.
 *
 * Crear también una clase Persona, que se caracteriza por un DNI y una lista de cuentas bancarias.
 *
 * La Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita añadir cuentas (hasta 3 el máximo permitido). Las cuentas se almacenarán en un array/vector. No usar una lista.
 *
 * Métodos de clase:
 *
 * Debe contener un método que devuelva si la persona es morosa (si tienen alguna cuenta con saldo negativo). Recibirá como parámetro el objeto Persona y devolverá un booleano.
 * Debe contener un método que realice una transferencia entre dos cuentas. Recibirá como parámetro dos objetos PersonaB, dos identificacdors de cuentas y la cantidad a transferir. Devolverá un booleano indicando si se ha podido realizar o no la operación.
 * En el programa principal, instanciar un objeto Persona con un DNI cualquiera, así como dos objetos cuenta, una sin saldo inicial y otra con 700 euros. La persona recibe la nómina mensual, por lo que ingresa 1100 euros en la primera cuenta, pero tiene que pagar el alquiler de 750 euros con la segunda. Imprimir por pantalla si la persona es morosa.
 *
 * Posteriormente hacer una transferencia de una cuenta a otra (de forma que todos los saldos sean positivos) y mostrar por pantalla el estado de la persona.
 */

fun main() {
    // Crear cuentas
    val cuenta1 = Cuenta(1)
    val cuenta2 = Cuenta(2, 500.0)
    println()

    // Crear persona
    val persona = Persona("49303030P")
    val persona2 = Persona("35698569H")
    println()

    // Agregar cuentas a la persona
    persona.aniadirCuenta(cuenta1)
    persona2.aniadirCuenta(cuenta2)
    println()

    // Realizar operaciones
    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPago(750.0)
    println()

    // Realizar transferencia entre cuentas
    persona.realizarTransferencia(persona, persona2, 0, 0, 500.00)
    println()

    // Mostrar estado final de la persona
    persona.mostrarInfoCuentas()
    println("La persona es morosa: ${persona.comprobarMorosidad()}")

    println()
    persona2.mostrarInfoCuentas()
    println("La persona es morosa: ${persona2.comprobarMorosidad()}")
}