class Persona(val dni: String, var cuentas: Array<Cuenta?> = Array(3) {null}){

    /**
     * Añade una cuenta a un array, tras comprobar si hay algun hueco libre de los 3 posibles (mirando si alguno es nulo).
     * @param cuenta Datos de el objeto Cuenta que se van a añadir
     */
    fun aniadirCuenta(cuenta: Cuenta) {
        if (cuentas.indexOf(null) != -1){
            cuentas[cuentas.indexOf(null)] = cuenta
            println("Cuenta añadida correctamente")
        }
        else { print("Error - Limite de cuentas alcanzado (3)") }
    }


    /**
     * Comprueba si alguna de las cuentas asociadas a la persona tiene saldo negativo.
     * @return true si alguna cuenta tiene saldo negativo, false en caso contrario.
     */
    fun comprobarMorosidad(): Boolean{
        for (cuenta in cuentas){
            if ((cuenta?.saldoDispo ?: 0.0) < 0){
                return true
            }
        }
        return false
    }

    /**
    * Realiza una transferencia entre cuentas de dos personas.
    * @param personaEnvia Persona que envía la transferencia
    * @param personaFinal Persona que recibe la transferencia
    * @param cuentaOrigen Índice de la cuenta de la personaEnvia de donde se transferirá el dinero
    * @param cuentaDestino Índice de la cuenta de la personaFinal a donde se transferirá el dinero
    * @param cantidad Monto a transferir
    * @return true si la transferencia fue exitosa, false en caso contrario.
    */
    //TODO
    fun realizarTransferencia(personaFinal: Persona, cuentaOrigen: Int, cuentaDestino: Int, cantidad: Double): Boolean {
        val cuentaEnvia = this.cuentas.find { (it?.numCuenta ?: -1) == cuentaOrigen }
        val cuentaRecibe = personaFinal.cuentas.find { (it?.numCuenta ?: -1) == cuentaDestino }

        if (cuentaEnvia != null && cuentaRecibe != null) {
            if (cuentaEnvia.saldoDispo >= cantidad) {
                cuentaEnvia.realizarPago(cantidad)
                cuentaRecibe.recibirAbono(cantidad)
                println("Transferencia realizada correctamente")
                return true
            }
        }
        println("No se pudo realizar la transferencia")
        return false
    }

    /**
     * Muestra la información de las cuentas asociadas a la persona.
     */
    fun mostrarInfoCuentas(){
        for (cuenta in cuentas){
            if (cuenta != null){
                println("NumCuenta: ${cuenta.numCuenta} Saldo: ${cuenta.saldoDispo}")
            }
        }
    }
}


