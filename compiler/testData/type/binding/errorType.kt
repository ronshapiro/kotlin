val ss: List<Pair<Int, out Float>, in Triple<List<Int>>>
/*
psi: List<Pair<Int, out Float>, in Triple<List<Int>>>
type: [ERROR : List<Pair<Int, out Float>, in Triple<List<Int>>>] {
    typeParameter: null
    typeProjection: Pair<Int, out Float>
    psi: Pair<Int, out Float>
    type: Pair<Int, out Float> {
        typeParameter: <X> defined in Pair
        typeProjection: Int
        psi: Int
        type: Int {}
        typeParameter: <Y> defined in Pair
        typeProjection: out Float
        psi: Float
        type: Float {}
    }
    typeParameter: null
    typeProjection: [ERROR : Triple<List<Int>>]
    psi: Triple<List<Int>>
    type: [ERROR : Triple<List<Int>>] {
        typeParameter: null
        typeProjection: List<Int>
        psi: List<Int>
        type: List<Int> {
            typeParameter: <out E> defined in kotlin.List
            typeProjection: Int
            psi: Int
            type: Int {}
        }
    }
}
*/