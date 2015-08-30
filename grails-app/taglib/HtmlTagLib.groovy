class HtmlTagLib {
    static namespace = "hl"

    static returnObjectForTags = [
            "getSportsTabs",
            "getLottoTabs",
            "getDivChartHeight",
            "chkLottoClass",
            "chkActiveClass"
    ]

    //check Active, if chkValue equals matchValue
    def chkActiveClass = {attrs, body ->
        def className = ""

        def chkValue = attrs.remove('chkValue')
        def matchValue = attrs.remove('matchValue')

        if (chkValue.equals(matchValue)) {
            className = "active"
        }

        return className
    }

    //check lottoClass
    def chkLottoClass = {attrs, body ->
        def className = ""

        def chkValue = attrs.remove('chkValue')

        if (chkValue.equals("NO")) { //一般號碼
            className = "lottoNO"
        } else if (chkValue.equals("SPNO")) { //特別號
            className = "lottoSPNO"
        } else if (chkValue.equals("RPNO")) { //連開
            className = "lottoRepeatNO"
        } else if (chkValue.equals("CTNO")) { //連續
            className = "lottoContinueNO"
        }

        return className
    }

    //取得直調圖長度
    def getDivChartHeight = { attrs, body ->
        def result
        def maxValue = attrs.remove('maxValue')
        def value = attrs.remove('value')

        result = (55 * ((value?:0) as Integer) / ((maxValue?:1) as Integer))?:0

        return result?:0
    }

    //運動分頁
    def getSportsTabs = { attrs, body ->
        def result = []

        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "sports.tab01.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkTianSia", params: [lv1IDX: 1])]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "sports.tab02.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688", params: [lv1IDX: 2])]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "sports.tab03.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688China", params: [lv1IDX: 3])]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "sports.tab04.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkSinSinBao", params: [lv1IDX: 4])]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "sports.tab05.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkYingSyong", params: [lv1IDX: 5])]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "sports.tab06.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkRongHuaHuei", params: [lv1IDX: 6])]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "sports.tab07.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkOther", params: [lv1IDX: 7])]

        return result
    }

    //彩球分頁
    def getLottoTabs = { attrs, body ->
        def result = []

        //tablv1
        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "lotto.tab01.label"),
                   link  : g.createLink(controller: "lotto", action: "customNewOpen", params: [lv1IDX: 1])]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "lotto.tab02.label"),
                   link  : g.createLink(controller: "lotto", action: "contentMarkSix", params: [lv1IDX: 2])]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "lotto.tab03.label"),
                   link  : g.createLink(controller: "lotto", action: "contentMarkSix", params: [lv1IDX: 3])]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "lotto.tab04.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto740", params: [lv1IDX: 4])]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "lotto.tab05.label"),
                   link  : g.createLink(controller: "lotto", action: "contentSuperLotto638", params: [lv1IDX: 5])]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "lotto.tab06.label"),
                   link  : g.createLink(controller: "lotto", action: "content38M6", params: [lv1IDX: 6])]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "lotto.tab07.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto649", params: [lv1IDX: 7])]
        result << [lv1IDX: 8, tabLv: 1, text: g.message(code: "lotto.tab08.label"),
                   link  : g.createLink(controller: "lotto", action: "content49M6", params: [lv1IDX: 8])]
        result << [lv1IDX: 9, tabLv: 1, text: g.message(code: "lotto.tab09.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto539", params: [lv1IDX: 9])]
        result << [lv1IDX: 10, tabLv: 1, text: g.message(code: "lotto.tab10.label"),
                   link  : g.createLink(controller: "lotto", action: "content39M5", params: [lv1IDX: 10])]
        result << [lv1IDX: 11, tabLv: 1, text: g.message(code: "lotto.tab11.label"),
                   link  : g.createLink(controller: "lotto", action: "content3D", params: [lv1IDX: 11])]
        result << [lv1IDX: 12, tabLv: 1, text: g.message(code: "lotto.tab12.label"),
                   link  : g.createLink(controller: "lotto", action: "content4D", params: [lv1IDX: 12])]
        result << [lv1IDX: 13, tabLv: 1, text: g.message(code: "lotto.tab13.label"),
                   link  : g.createLink(controller: "lotto", action: "contentBingoBingo", params: [lv1IDX: 13])]

        result << [lv1IDX: 3, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab03.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentMarkSix", params: [lv1IDX: 3, lv2IDX: 1])]
        result << [lv1IDX: 3, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab03.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryMarkSix", params: [lv1IDX: 3, lv2IDX: 2])]
        result << [lv1IDX: 3, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab03.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatMarkSix", params: [lv1IDX: 3, lv2IDX: 3])]
        result << [lv1IDX: 3, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab03.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueMarkSix", params: [lv1IDX: 3, lv2IDX: 4])]
        result << [lv1IDX: 3, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab03.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberMarkSix", params: [lv1IDX: 3, lv2IDX: 5])]

        result << [lv1IDX: 4, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab04.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto740", params: [lv1IDX: 4, lv2IDX: 1])]
        result << [lv1IDX: 4, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab04.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto740", params: [lv1IDX: 4, lv2IDX: 2])]
        result << [lv1IDX: 4, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab04.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto740", params: [lv1IDX: 4, lv2IDX: 3])]
        result << [lv1IDX: 4, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab04.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto740", params: [lv1IDX: 4, lv2IDX: 4])]
        result << [lv1IDX: 4, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab04.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto740", params: [lv1IDX: 4, lv2IDX: 5])]

        result << [lv1IDX: 5, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab05.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentSuperLotto638", params: [lv1IDX: 5, lv2IDX: 1])]
        result << [lv1IDX: 5, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab05.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistorySuperLotto638", params: [lv1IDX: 5, lv2IDX: 2])]
        result << [lv1IDX: 5, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab05.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatSuperLotto638", params: [lv1IDX: 5, lv2IDX: 3])]
        result << [lv1IDX: 5, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab05.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueSuperLotto638", params: [lv1IDX: 5, lv2IDX: 4])]
        result << [lv1IDX: 5, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab05.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberSuperLotto638", params: [lv1IDX: 5, lv2IDX: 5])]

        result << [lv1IDX: 6, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab06.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content38M6", params: [lv1IDX: 6, lv2IDX: 1])]
        result << [lv1IDX: 6, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab06.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory38M6", params: [lv1IDX: 6, lv2IDX: 2])]
        result << [lv1IDX: 6, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab06.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat38M6", params: [lv1IDX: 6, lv2IDX: 3])]
        result << [lv1IDX: 6, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab06.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue38M6", params: [lv1IDX: 6, lv2IDX: 4])]
        result << [lv1IDX: 6, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab06.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber38M6", params: [lv1IDX: 6, lv2IDX: 5])]

        result << [lv1IDX: 7, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab07.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto649", params: [lv1IDX: 7, lv2IDX: 1])]
        result << [lv1IDX: 7, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab07.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto649", params: [lv1IDX: 7, lv2IDX: 2])]
        result << [lv1IDX: 7, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab07.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto649", params: [lv1IDX: 7, lv2IDX: 3])]
        result << [lv1IDX: 7, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab07.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto649", params: [lv1IDX: 7, lv2IDX: 4])]
        result << [lv1IDX: 7, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab07.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto649", params: [lv1IDX: 7, lv2IDX: 5])]

        result << [lv1IDX: 8, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab08.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content49M6", params: [lv1IDX: 8, lv2IDX: 1])]
        result << [lv1IDX: 8, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab08.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory49M6", params: [lv1IDX: 8, lv2IDX: 2])]
        result << [lv1IDX: 8, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab08.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat49M6", params: [lv1IDX: 8, lv2IDX: 3])]
        result << [lv1IDX: 8, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab08.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue49M6", params: [lv1IDX: 8, lv2IDX: 4])]
        result << [lv1IDX: 8, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab08.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber49M6", params: [lv1IDX: 8, lv2IDX: 5])]

        result << [lv1IDX: 9, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab09.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto539", params: [lv1IDX: 9, lv2IDX: 1])]
        result << [lv1IDX: 9, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab09.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto539", params: [lv1IDX: 9, lv2IDX: 2])]
        result << [lv1IDX: 9, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab09.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto539", params: [lv1IDX: 9, lv2IDX: 3])]
        result << [lv1IDX: 9, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab09.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto539", params: [lv1IDX: 9, lv2IDX: 4])]
        result << [lv1IDX: 9, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab09.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto539", params: [lv1IDX: 9, lv2IDX: 5])]

        result << [lv1IDX: 10, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab10.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content39M5", params: [lv1IDX: 10, lv2IDX: 1])]
        result << [lv1IDX: 10, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab10.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory39M5", params: [lv1IDX: 10, lv2IDX: 2])]
        result << [lv1IDX: 10, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab10.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat39M5", params: [lv1IDX: 10, lv2IDX: 3])]
        result << [lv1IDX: 10, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab10.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue39M5", params: [lv1IDX: 10, lv2IDX: 4])]
        result << [lv1IDX: 10, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab10.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber39M5", params: [lv1IDX: 10, lv2IDX: 5])]

        result << [lv1IDX: 11, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab11.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content3D", params: [lv1IDX: 11, lv2IDX: 1])]
        result << [lv1IDX: 11, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab11.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory3D", params: [lv1IDX: 11, lv2IDX: 2])]

        result << [lv1IDX: 12, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab12.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content4D", params: [lv1IDX: 12, lv2IDX: 1])]
        result << [lv1IDX: 12, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab12.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory4D", params: [lv1IDX: 12, lv2IDX: 2])]

        result << [lv1IDX: 13, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab13.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentBingoBingo", params: [lv1IDX: 13, lv2IDX: 1])]
        result << [lv1IDX: 13, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab13.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryBingoBingo", params: [lv1IDX: 13, lv2IDX: 2])]
        result << [lv1IDX: 13, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab13.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatBingoBingo", params: [lv1IDX: 13, lv2IDX: 3])]
        result << [lv1IDX: 13, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab13.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueBingoBingo", params: [lv1IDX: 13, lv2IDX: 4])]


//        result << [tabIDX: 3, text: g.message(code: "lotto.tab03.subTab01.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLink35688China", params: [tabLv1: 3, tablv2: 1])]
//        result << [tabIDX: 4, text: g.message(code: "lotto.tab04.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkSinSinBao", params: [tabLv1: 4])]
//        result << [tabIDX: 5, text: g.message(code: "lotto.tab05.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkYingSyong", params: [tabLv1: 5])]
//        result << [tabIDX: 6, text: g.message(code: "lotto.tab06.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkRongHuaHuei", params: [tabLv1: 6])]
//        result << [tabIDX: 7, text: g.message(code: "lotto.tab07.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 7])]
//        result << [tabIDX: 8, text: g.message(code: "lotto.tab08.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 8])]
//        result << [tabIDX: 9, text: g.message(code: "lotto.tab09.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 9])]
//        result << [tabIDX: 10, text: g.message(code: "lotto.tab10.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 10])]
//        result << [tabIDX: 11, text: g.message(code: "lotto.tab11.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 11])]
//        result << [tabIDX: 12, text: g.message(code: "lotto.tab12.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 12])]
//        result << [tabIDX: 13, text: g.message(code: "lotto.tab13.label"),
//                   link  : g.createLink(controller: "lotto", action: "webLinkOther", params: [tabLv1: 13])]

//        println "result = " + result
        return result
    }
}
