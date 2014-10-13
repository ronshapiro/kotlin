val foo = getT<List<Pair<Int, out List<*>>>>()
/*
psi: val foo = getT<List<Pair<Int, out List<*>>>>()
type: List<Pair<Int, out List<Any?>>> {
    typeParameter: <out E> defined in kotlin.List
    typeProjection: Pair<Int, out List<Any?>>
    psi: val foo = getT<List<Pair<Int, out List<*>>>>()
    type: Pair<Int, out List<Any?>> {
        typeParameter: <X> defined in Pair
        typeProjection: Int
        psi: val foo = getT<List<Pair<Int, out List<*>>>>()
        type: Int {}
        typeParameter: <Y> defined in Pair
        typeProjection: out List<Any?>
        psi: val foo = getT<List<Pair<Int, out List<*>>>>()
        type: List<Any?> {
            typeParameter: <out E> defined in kotlin.List
            typeProjection: Any?
            psi: val foo = getT<List<Pair<Int, out List<*>>>>()
            type: Any? {}
        }
    }
}
*/