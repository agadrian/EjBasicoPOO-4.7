
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


