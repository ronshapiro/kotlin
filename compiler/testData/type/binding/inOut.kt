val foo: In<in Out<Inv<out Int>>> = null!!
/*
psi: In<in Out<Inv<out Int>>>
type: In<in Out<Inv<out Int>>> {
    typeParameter: <in T> defined in In
    typeProjection: in Out<Inv<out Int>>
    psi: Out<Inv<out Int>>
    type: Out<Inv<out Int>> {
        typeParameter: <out T> defined in Out
        typeProjection: Inv<out Int>
        psi: Inv<out Int>
        type: Inv<out Int> {
            typeParameter: <T> defined in Inv
            typeProjection: out Int
            psi: Int
            type: Int {}
        }
    }
}
*/