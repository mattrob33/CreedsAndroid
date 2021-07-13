package com.mattrobertson.creeds.data.creeds

import com.mattrobertson.creeds.model.creed.Creed

val apostlesCreed = Creed(
    title = "Apostles Creed",
    abbreviation = "apostles",
    year = 200,
    text = """
        I believe in God, the Father almighty,
        creator of heaven and earth.

        I believe in Jesus Christ, God’s only Son, our Lord,
        who was conceived by the Holy Spirit,
        born of the Virgin Mary,
        suffered under Pontius Pilate,
        was crucified, died, and was buried;
        he descended to the dead.
        On the third day he rose again;
        he ascended into heaven,
        he is seated at the right hand of the Father,
        and he will come to judge the living and the dead.

        I believe in the Holy Spirit,
        the holy catholic Church,
        the communion of saints,
        the forgiveness of sins,
        the resurrection of the body,
        and the life everlasting. Amen.
    """.trimIndent()
)