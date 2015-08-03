class ToolsTagLib {
    static namespace = "bs"

    static returnObjectForTags = [
            "bs101",
            "bs101s"
    ]

    //���oBS101�W��
    def bs101 = { attrs, body ->
        def ptype = attrs.remove('ptype')
        def pcode = attrs.remove('pcode')

        return Bs101.findByPtypeAndPcode(ptype, pcode)?.pdesc ?: attrs.notfound ?: ""
    }

    //���oBS101�Ѽ�List
    def bs101s = { attrs, body ->
        def ptype = attrs.remove('ptype')

        def list = Bs101.findAllByPtype(ptype, [sort: "porder", order: "asc"])
        return list
    }

}
