class Cuenta(val numCuenta: Int, saldoDispo: Double = 0.0){

    var saldoDispo: Double = saldoDispo
        private set


    /**
     * Consulta el saldo disponible de la cuenta.
     * @return El saldo disponible de la cuenta.
     */
    fun consultarSaldo(): Double{
        return this.saldoDispo
    }

    /**
     * Recibe un abono en la cuenta, aumentando el saldo disponible.
     * @param cantidad La cantidad a abonar en la cuenta.
     */
    fun recibirAbono(cantidad: Double){
        println("Has recibido billetes: ${cantidad}€")
        this.saldoDispo += cantidad
    }

    /**
     * Realiza un pago desde la cuenta, disminuyendo el saldo disponible.
     * @param cantidad La cantidad a pagar desde la cuenta.
     */
    fun realizarPago(cantidad: Double){
        this.saldoDispo -= cantidad
        println("Has pagado: ${cantidad}€")

    }
}

