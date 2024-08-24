-- user table example data
INSERT IGNORE INTO `user` (`user_id`, `user_pw`, `current_character_id`, `created_date`, `updated_date`)
VALUES ('investorking', 'password123', 'inflation_beast', NOW(), NOW()),
       ('cryptoqueen', 'securePass456', 'deflation_dragon', NOW(), NOW()),
       ('wallstreetwolf', 'tradeMaster789', 'recession_reaper', NOW(), NOW()),
       ('stockguru', 'investorPro321', 'liquidity_trap', NOW(), NOW()),
       ('economyexpert', 'financeWizard654', 'stagflation_serpent', NOW(), NOW()),
       ('marketmaven', 'growthHacker987', 'credit_crunch_creeper', NOW(), NOW()),
       ('bondboss', 'fixedIncome222', 'housing_bubble_hound', NOW(), NOW()),
       ('commoditieschamp', 'goldSilver111', 'currency_crisis_cyclops', NOW(), NOW()),
       ('derivativesduke', 'optionsFutures444', 'trade_war_titan', NOW(), NOW()),
       ('forexphenom', 'currencyPro555', 'debt_dragon', NOW(), NOW());

-- asset table example data
INSERT IGNORE INTO `asset` (`user_id`, `asset_amount`, `created_date`, `updated_date`)
VALUES ('investorking', 1500000, NOW(), NOW()),
       ('cryptoqueen', 250000, NOW(), NOW()),
       ('wallstreetwolf', 5000000, NOW(), NOW()),
       ('stockguru', 3200000, NOW(), NOW()),
       ('economyexpert', 1200000, NOW(), NOW()),
       ('marketmaven', 980000, NOW(), NOW()),
       ('bondboss', 750000, NOW(), NOW()),
       ('commoditieschamp', 450000, NOW(), NOW()),
       ('derivativesduke', 1800000, NOW(), NOW()),
       ('forexphenom', 2100000, NOW(), NOW());

-- monster table example data
INSERT IGNORE INTO `monster` (`monster_id`, `monster_name`, `monster_desc`, `monster_image_url`, `monster_model_url`,
                       `created_date`, `updated_date`)
VALUES ('inflation_beast', '인플레이션 괴물', '구매력을 파괴하는 인플레이션의 파괴적 힘을 상징하는 괴물.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('deflation_dragon', '디플레이션 용', '경제 둔화와 가격 하락을 상징하는 강력한 용.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('recession_reaper', '불황의 사신', '경제 하락을 상징하는 존재로, 대규모 실업과 기업 파산을 초래함.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('liquidity_trap', '유동성 함정', '통화 정책이 효과를 발휘하지 못하는 경제 상태를 가두는 괴물.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('stagflation_serpent', '스태그플레이션 뱀', '저성장, 높은 실업률, 상승하는 물가를 초래하는 뱀.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('credit_crunch_creeper', '신용 경색 요정', '신용 시장을 얼어붙게 하여 경제를 마비시키는 요정.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('housing_bubble_hound', '부동산 거품 사냥개', '지속 가능한 수준을 초과하여 부동산 가격을 상승시키고 결국 붕괴를 초래하는 사냥개.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('currency_crisis_cyclops', '통화 위기 사이클롭스', '국가 통화를 불안정하게 만들어 금융 공황을 일으키는 외눈박이 거인.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('trade_war_titan', '무역전쟁 거인', '관세와 무역 장벽을 증가시켜 글로벌 무역에 해를 끼치는 거인.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW()),
       ('debt_dragon', '채무 용', '과도한 채무의 위험을 나타내며 금융 안정성을 위협하는 용.',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png',
        'https://w7.pngwing.com/pngs/237/587/png-transparent-cute-pikachu-thumbnail.png', NOW(), NOW());

-- theme table example data
INSERT IGNORE INTO `theme` (`theme_id`, `theme_name`, `theme_desc`, `created_date`, `updated_date`)
VALUES ('great_depression', '1929 세계 경제 대공황', '전 세계적으로 발생한 대규모 경제 붕괴로, 수백만 명의 실업자와 기업 파산이 발생.', NOW(), NOW()),
       ('world_war_ii', '1944 2차 세계대전', '전후 경제 재건과 함께 브레튼우즈 체제가 도입되어 새로운 국제 경제 질서가 형성됨.', NOW(), NOW()),
       ('oil_shock', '1973 오일쇼크', '중동의 원유 수출국들이 원유 생산을 제한하여 세계 경제에 큰 혼란을 초래함.', NOW(), NOW()),
       ('lost_decade_japan', '1980 일본의 잃어버린 10년', '자산 가격 거품이 붕괴되면서 일본 경제가 장기 침체에 빠짐.', NOW(), NOW()),
       ('eurozone', '1999 유로존', '유럽의 단일 통화인 유로가 도입되어 유럽 경제 통합이 촉진됨.', NOW(), NOW()),
       ('subprime_crisis', '2008 서브프라임 모기지', '미국 주택 시장의 붕괴로 인해 글로벌 금융 위기가 발생.', NOW(), NOW()),
       ('brexit', '2016 브렉시트', '영국이 유럽 연합 탈퇴를 결정하면서 정치적, 경제적 불확실성이 커짐.', NOW(), NOW()),
       ('crypto_revolution', '2017 암호화폐 혁명', '비트코인과 같은 암호화폐가 주류 투자 자산으로 떠오르며 금융 시스템에 도전.', NOW(), NOW()),
       ('covid19_pandemic', '2019 코로나 19 팬데믹', '전 세계적인 팬데믹이 경제 활동을 중단시키고 글로벌 경제에 큰 타격을 줌.', NOW(), NOW()),
       ('asia_market_crash', '2024 아시아 증시 대폭락', '아시아 지역의 증시가 대규모로 폭락하여 글로벌 경제에 충격을 줌.', NOW(), NOW());

-- AI_PROMPT table example data
INSERT IGNORE INTO `ai_prompt` (`ai_prompt_id`, `ai_prompt_class`, `ai_question`, `ai_answer`, `created_date`, `updated_date`)
VALUES ('DEPRESSION', 'QUIZ',
        '1929년 세계 경제 대공황 시기에는 어떤 투자수단이 적합한가요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["금", "채권", "필수 소비재"],
        "subInvestCategory": {
            "금": [
                {"물리적 금": {"fluctuationRate": 5.2, "description": "금은 경제 위기 시기에 안전한 투자처로 여겨졌습니다. 대공황 시기에는 금 보유가 특히 중요했습니다."}},
                {"금 ETF": {"fluctuationRate": 4.8, "description": "금 ETF는 금을 직접 보유하지 않고도 금에 투자할 수 있는 수단으로, 대공황 기간 동안 많은 투자자들이 이를 선호했습니다."}},
                {"금 광산 주식": {"fluctuationRate": -3.1, "description": "금 가격이 상승하더라도 일부 금 광산 주식은 생산 비용 증가로 인해 손실을 보았습니다."}}],
            "채권": [
                {"국채": {"fluctuationRate": 2.5, "description": "정부가 발행하는 국채는 대공황 기간 동안 안전한 투자 수단으로 인식되었습니다."}},
                {"회사채": {"fluctuationRate": -1.5, "description": "일부 기업들은 대공황으로 인해 부채 상환에 어려움을 겪었고, 이는 회사채의 가치 하락으로 이어졌습니다."}},
                {"인플레이션 연계 채권": {"fluctuationRate": 2.8, "description": "인플레이션에 따라 조정되는 이 채권은 경제적 불확실성 시기에 좋은 방어책이 될 수 있었습니다."}}],
            "필수 소비재": [
                {"식료품": {"fluctuationRate": 1.8, "description": "식료품 산업은 대공황 기간 동안에도 안정적인 수익을 유지했습니다."}},
                {"의약품": {"fluctuationRate": 1.5, "description": "의약품은 필수 소비재로서 경제적 불황에도 꾸준히 수요가 있었습니다."}},
                {"생활용품": {"fluctuationRate": 2.0, "description": "비누, 세제 등 생활용품은 필수적이었으며, 대공황 중에도 안정적인 판매를 기록했습니다."}}]
            }}', NOW(), NOW()),

       ('WW2', 'QUIZ',
        '2차 세계대전 이후의 경제 질서를 고려하여, 어떤 투자수단이 적합할까요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["부동산", "산업재", "에너지"],
        "subInvestCategory": {
            "부동산": [
                {"상업용 부동산": {"fluctuationRate": 3.9, "description": "전후 재건으로 인해 상업용 부동산의 수요가 급증했습니다."}},
                {"주거용 부동산": {"fluctuationRate": 4.2, "description": "전쟁 후 인구 증가와 도시 확장으로 주거용 부동산 가격이 상승했습니다."}},
                {"부동산 펀드": {"fluctuationRate": -2.0, "description": "일부 부동산 펀드는 전후 경제 불확실성으로 인해 손실을 보았습니다."}}],
            "산업재": [
                {"기계": {"fluctuationRate": 5.6, "description": "기계 산업은 전후 재건과 산업화로 인해 높은 수익률을 기록했습니다."}},
                {"건설": {"fluctuationRate": -3.4, "description": "건설 산업은 자재 부족과 인건비 상승으로 일부 손실을 겪었습니다."}},
                {"화학": {"fluctuationRate": 5.9, "description": "화학 산업은 전후 산업 발전과 함께 빠르게 성장했습니다."}}],
            "에너지": [
                {"석유": {"fluctuationRate": 7.3, "description": "전후 경제 복구 과정에서 에너지 수요가 급증하여 석유 가격이 상승했습니다."}},
                {"천연가스": {"fluctuationRate": 6.5, "description": "천연가스는 산업 및 가정용 연료로 수요가 증가했습니다."}},
                {"전력": {"fluctuationRate": -4.0, "description": "일부 전력 기업은 전쟁으로 인한 시설 파괴로 손실을 보았습니다."}}]
            }}', NOW(), NOW()),

       ('OIL_SHOCK', 'QUIZ', '1973년 오일쇼크 시기에는 어떤 투자수단이 적합한가요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["에너지", "귀금속", "인프라"],
        "subInvestCategory": {
            "에너지": [
                {"원유": {"fluctuationRate": 8.0, "description": "오일쇼크로 인해 원유 가격이 급등하여 에너지 부문이 높은 수익을 기록했습니다."}},
                {"에너지 주식": {"fluctuationRate": -5.0, "description": "일부 에너지 기업은 비용 상승과 수요 감소로 인해 손실을 보았습니다."}},
                {"에너지 ETF": {"fluctuationRate": 6.8, "description": "에너지 섹터에 투자한 ETF는 오일쇼크로 인해 수익이 상승했습니다."}}],
            "귀금속": [
                {"금": {"fluctuationRate": 5.5, "description": "오일쇼크 기간 동안 금은 안전자산으로 인식되어 가격이 상승했습니다."}},
                {"은": {"fluctuationRate": -2.2, "description": "은은 상대적으로 덜 안전하다고 여겨져 가격이 하락했습니다."}},
                {"플래티넘": {"fluctuationRate": 5.7, "description": "플래티넘은 산업적 수요로 인해 가격이 상승했습니다."}}],
            "인프라": [
                {"교통": {"fluctuationRate": 4.4, "description": "교통 인프라 투자 자산은 에너지 가격 상승으로 일부 긍정적 영향을 받았습니다."}},
                {"통신": {"fluctuationRate": -3.3, "description": "통신 인프라는 높은 비용 구조로 인해 일부 손실을 보았습니다."}},
                {"전력": {"fluctuationRate": 4.2, "description": "전력 인프라는 에너지 가격 상승으로 인해 수익이 증가했습니다."}}]
            }}', NOW(), NOW()),

       ('JAPAN_LOST_DECADE', 'QUIZ',
        '일본의 잃어버린 10년 동안 어떤 투자수단이 적합했나요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["채권", "안전자산", "대체투자"],
        "subInvestCategory": {
            "채권": [
                {"국채": {"fluctuationRate": 2.0, "description": "일본 정부가 발행한 국채는 안정적인 수익을 제공했습니다."}},
                {"회사채": {"fluctuationRate": -1.0, "description": "경제 침체로 인해 일부 기업들은 채무 상환에 어려움을 겪었습니다."}},
                {"지방채": {"fluctuationRate": 1.8, "description": "지방 정부의 채권은 상대적으로 안전한 투자처로 여겨졌습니다."}}],
            "안전자산": [
                {"금": {"fluctuationRate": 3.4, "description": "금은 일본 경제 침체 기간 동안 안전한 투자 자산으로 선호되었습니다."}},
                {"현금": {"fluctuationRate": 1.2, "description": "현금 보유는 변동성이 큰 시장에서 안정성을 제공했습니다."}},
                {"외환": {"fluctuationRate": -2.5, "description": "엔화의 약세로 인해 일부 외환 자산은 손실을 보았습니다."}}],
            "대체투자": [
                {"헷지펀드": {"fluctuationRate": 4.1, "description": "헷지펀드는 다양한 전략을 통해 일본 경제 침체에서 비교적 높은 수익을 기록했습니다."}},
                {"사모펀드": {"fluctuationRate": 4.7, "description": "사모펀드는 장기적인 투자 전략으로 안정적인 수익을 목표로 했습니다."}},
                {"부동산": {"fluctuationRate": -3.8, "description": "일본의 부동산 시장은 거품 붕괴로 인해 심각한 손실을 입었습니다."}}]
            }}', NOW(), NOW()),

       ('EUROZONE', 'QUIZ', '유로존 도입 이후 어떤 투자수단이 적합했나요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["유럽주식", "통화", "부동산"],
        "subInvestCategory": {
            "유럽주식": [
                {"대형주": {"fluctuationRate": 4.5, "description": "유럽의 대형주는 유로존 도입으로 인한 경제 통합으로 이익을 보았습니다."}},
                {"소형주": {"fluctuationRate": -1.8, "description": "소형주는 대형주 대비 유동성 부족과 경제 불확실성으로 인해 손실을 보았습니다."}},
                {"배당주": {"fluctuationRate": 4.3, "description": "배당주 투자자는 안정적인 수익을 기대할 수 있었습니다."}}],
            "통화": [
                {"유로": {"fluctuationRate": 3.7, "description": "유로화는 초기에는 강세를 보였으나 경제적 변동성으로 인해 시간이 지나면서 안정되었습니다."}},
                {"스위스 프랑": {"fluctuationRate": 3.2, "description": "스위스 프랑은 안전자산으로 여겨져 유로존 불안정 시기에 강세를 보였습니다."}},
                {"영국 파운드": {"fluctuationRate": -2.4, "description": "영국 파운드는 유로존 도입에 따른 경제적 변화로 일부 하락을 경험했습니다."}}],
            "부동산": [
                {"상업용 부동산": {"fluctuationRate": 3.9, "description": "상업용 부동산은 유로존 경제 활성화로 수익을 올렸습니다."}},
                {"주거용 부동산": {"fluctuationRate": 4.0, "description": "주거용 부동산은 인구 증가와 경제 안정으로 인해 가격이 상승했습니다."}},
                {"부동산 리츠": {"fluctuationRate": -3.1, "description": "부동산 리츠는 일부 경제적 불확실성으로 인해 가격이 하락했습니다."}}]
            }}', NOW(), NOW()),

       ('SUBPRIME_CRISIS', 'QUIZ',
        '2008년 서브프라임 모기지 사태 이후 어떤 투자수단이 적합했나요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["안전자산", "금융주", "대체투자"],
        "subInvestCategory": {
            "안전자산": [
                {"미국 국채": {"fluctuationRate": 2.5, "description": "미국 국채는 글로벌 금융 위기 동안 안전한 투자처로 여겨졌습니다."}},
                {"금": {"fluctuationRate": 4.8, "description": "금은 경제 불확실성 속에서 안전자산으로 큰 인기를 끌었습니다."}},
                {"저축성 상품": {"fluctuationRate": -1.1, "description": "저축성 상품은 낮은 수익률로 인해 일부 손실을 보았습니다."}}],
            "금융주": [
                {"대형은행": {"fluctuationRate": 5.4, "description": "대형은행은 금융 위기 이후 정부의 지원을 받아 회복되었습니다."}},
                {"보험": {"fluctuationRate": -3.3, "description": "보험 업계는 위기 동안 큰 손실을 입었지만 이후 회복되었습니다."}},
                {"자산관리": {"fluctuationRate": 4.0, "description": "자산관리 회사들은 위기 이후 투자의 다변화로 인해 이익을 회복했습니다."}}],
            "대체투자": [
                {"헷지펀드": {"fluctuationRate": 4.6, "description": "헷지펀드는 다양한 투자 전략으로 금융 위기 동안 상대적으로 안정적인 수익을 냈습니다."}},
                {"부동산": {"fluctuationRate": -4.9, "description": "부동산 시장은 서브프라임 모기지 사태로 인해 심각한 타격을 받았습니다."}},
                {"채권펀드": {"fluctuationRate": 3.5, "description": "채권펀드는 안전자산으로서 인기를 끌었으나 수익률은 제한적이었습니다."}}]
            }}', NOW(), NOW()),

       ('BREXIT', 'QUIZ', '브렉시트 이후 어떤 투자수단이 적합할까요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["통화", "국채", "유럽주식"],
        "subInvestCategory": {
            "통화": [
                {"영국 파운드": {"fluctuationRate": -3.2, "description": "브렉시트로 인해 영국 파운드는 큰 변동성을 보였습니다."}},
                {"유로": {"fluctuationRate": 3.0, "description": "유로는 브렉시트 후 유럽 경제의 불확실성에도 불구하고 강세를 유지했습니다."}},
                {"미국 달러": {"fluctuationRate": 3.7, "description": "미국 달러는 글로벌 불안정 속에서 안전한 투자처로서 인기를 끌었습니다."}}],
            "국채": [
                {"영국 국채": {"fluctuationRate": 2.8, "description": "영국 국채는 안전한 자산으로 여겨져 브렉시트 이후 수요가 증가했습니다."}},
                {"독일 국채": {"fluctuationRate": 2.5, "description": "독일 국채는 유럽 내에서의 안정적인 투자처로 인식되었습니다."}},
                {"프랑스 국채": {"fluctuationRate": -1.7, "description": "프랑스 국채는 경제적 불확실성으로 인해 일부 하락을 겪었습니다."}}],
            "유럽주식": [
                {"대형주": {"fluctuationRate": 4.3, "description": "유럽의 대형주는 브렉시트 이후 안정적인 수익을 기록했습니다."}},
                {"소형주": {"fluctuationRate": -3.0, "description": "소형주는 시장의 불확실성 속에서 큰 타격을 받았습니다."}},
                {"배당주": {"fluctuationRate": 4.1, "description": "배당주는 안정적인 수익을 제공하여 투자자들에게 매력적인 선택이었습니다."}}]
            }}', NOW(), NOW()),

       ('CRYPTO_REVOLUTION', 'QUIZ',
        '암호화폐 혁명 시기에는 어떤 투자수단이 적합했나요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["암호화폐", "블록체인 기술", "핀테크"],
        "subInvestCategory": {
            "암호화폐": [
                {"비트코인": {"fluctuationRate": 7.0, "description": "비트코인은 암호화폐 시장에서 가장 널리 알려진 자산으로, 큰 변동성을 보였습니다."}},
                {"이더리움": {"fluctuationRate": 6.5, "description": "이더리움은 스마트 계약 기능으로 인기를 끌었으나, 변동성은 매우 컸습니다."}},
                {"리플": {"fluctuationRate": -5.5, "description": "리플은 규제 문제와 시장 변동성으로 인해 상당한 손실을 겪었습니다."}}],
            "블록체인 기술": [
                {"블록체인 플랫폼": {"fluctuationRate": 5.0, "description": "블록체인 플랫폼은 금융 및 비즈니스 모델 혁신의 핵심으로 주목받았습니다."}},
                {"스마트 계약": {"fluctuationRate": -2.3, "description": "스마트 계약 기술은 초기 도입 과정에서 일부 문제를 겪었습니다."}},
                {"디파이": {"fluctuationRate": 4.8, "description": "디파이(탈중앙 금융)는 높은 성장 가능성으로 많은 투자자들에게 주목받았습니다."}}],
            "핀테크": [
                {"디지털 은행": {"fluctuationRate": 6.0, "description": "디지털 은행은 전통적인 금융 모델을 혁신하며 높은 성장을 이루었습니다."}},
                {"결제 서비스": {"fluctuationRate": 5.7, "description": "온라인 결제 서비스는 암호화폐의 도입과 함께 빠르게 성장했습니다."}},
                {"핀테크 ETF": {"fluctuationRate": -3.5, "description": "일부 핀테크 ETF는 시장 변동성으로 인해 손실을 보았습니다."}}]
            }}', NOW(), NOW()),

       ('COVID19', 'QUIZ', '코로나 19 팬데믹 시기에는 어떤 투자수단이 적합했나요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["헬스케어", "기술주", "원격 서비스"],
        "subInvestCategory": {
            "헬스케어": [
                {"제약": {"fluctuationRate": 5.2, "description": "코로나19 백신 및 치료제 개발로 제약 산업은 급성장했습니다."}},
                {"바이오": {"fluctuationRate": 4.9, "description": "바이오 산업은 팬데믹 동안 혁신적인 치료 방법 개발로 주목받았습니다."}},
                {"의료기기": {"fluctuationRate": 3.0, "description": "의료기기 산업은 팬데믹 기간 동안 필수 의료 장비의 수요 증가로 성장했습니다."}}],
            "기술주": [
                {"클라우드 컴퓨팅": {"fluctuationRate": 6.5, "description": "재택근무 확산으로 클라우드 컴퓨팅 서비스의 수요가 폭발적으로 증가했습니다."}},
                {"사이버 보안": {"fluctuationRate": 4.7, "description": "온라인 활동 증가로 사이버 보안 솔루션의 필요성이 강조되었습니다."}},
                {"전자상거래": {"fluctuationRate": -2.8, "description": "일부 전자상거래 업체는 공급망 문제와 함께 초기 손실을 보았습니다."}}],
            "원격 서비스": [
                {"화상회의": {"fluctuationRate": 6.8, "description": "화상회의 서비스는 팬데믹 동안 필수적인 비즈니스 도구로 자리 잡았습니다."}},
                {"원격의료": {"fluctuationRate": 5.3, "description": "원격의료 서비스는 사회적 거리두기와 비대면 진료의 필요성으로 크게 성장했습니다."}},
                {"온라인 교육": {"fluctuationRate": -3.7, "description": "일부 온라인 교육 플랫폼은 기술적 문제와 초기 도입의 어려움으로 인해 손실을 겪었습니다."}}]
            }}', NOW(), NOW()),

       ('ASIA_MARKET_CRASH', 'QUIZ',
        '2024년 아시아 증시 대폭락 이후 어떤 투자수단이 적합할까요? 당시의 경제적 상황을 고려해 대분류 투자수단 3가지와 각각의 소분류 투자수단 3가지씩을 추천해주세요.',
        '{"majorInvestCategory": ["안전자산", "에너지", "미국주식"],
        "subInvestCategory": {
            "안전자산": [
                {"미국 국채": {"fluctuationRate": 2.5, "description": "아시아 시장의 불확실성 속에서 미국 국채는 안전한 투자처로 여겨졌습니다."}},
                {"금": {"fluctuationRate": 4.2, "description": "금은 글로벌 시장의 변동성 속에서 안전자산으로서 큰 인기를 끌었습니다."}},
                {"달러": {"fluctuationRate": -1.3, "description": "달러화는 강세를 보였으나, 일부 시장에서는 다른 자산에 비해 변동성을 겪었습니다."}}],
            "에너지": [
                {"석유": {"fluctuationRate": 3.9, "description": "석유 가격은 에너지 수요 증가로 인해 일시적으로 상승했으나, 장기적으로는 변동성이 컸습니다."}},
                {"천연가스": {"fluctuationRate": 4.0, "description": "천연가스는 산업용 수요 증가로 인해 긍정적인 성과를 보였습니다."}},
                {"재생에너지": {"fluctuationRate": -2.7, "description": "재생에너지 분야는 기술적 문제와 초기 비용 증가로 인해 일부 손실을 보았습니다."}}],
            "미국주식": [
                {"대형 기술주": {"fluctuationRate": 5.5, "description": "미국의 대형 기술주는 아시아 시장 불안정 속에서도 강세를 유지했습니다."}},
                {"헬스케어": {"fluctuationRate": 4.8, "description": "헬스케어 분야는 팬데믹 이후 지속적인 성장세를 보였습니다."}},
                {"산업재": {"fluctuationRate": -3.2, "description": "미국의 일부 산업재는 공급망 문제와 수요 감소로 인해 손실을 입었습니다."}}]
            }}', NOW(), NOW()),
       ('INVEST_HEAVILY', 'FEEDBACK', '전체 자산 중 80% 이상을 주식에 투자했을 때, 어떤 피드백을 받을 수 있을까요?',
        '{"assetFeedback": "포트폴리오가 너무 공격적입니다. 리스크 관리를 위해 자산 배분을 재고해야 합니다.", "investFeedback": "변동성이 큰 시장에서는 조정이 필요할 수 있습니다."}',
        NOW(), NOW()),
       ('INVEST_A_LOT', 'FEEDBACK', '전체 자산 중 50~80%를 주식에 투자했을 때, 어떤 피드백을 받을 수 있을까요?',
        '{"assetFeedback": "상당히 높은 비중이 주식에 투자되어 있습니다. 시장 상황을 주시하면서 자산 배분을 다시 검토하세요.", "investFeedback": "장기적인 관점에서 추가적인 투자 기회를 탐색할 수 있습니다."}',
        NOW(), NOW()),
       ('INVEST_MODERATELY', 'FEEDBACK', '전체 자산 중 30~50%를 주식에 투자했을 때, 어떤 피드백을 받을 수 있을까요?',
        '{"assetFeedback": "적절한 비율로 주식에 투자하고 있습니다. 시장 변동성을 고려해 꾸준히 자산을 관리하세요.", "investFeedback": "안정적인 성장을 목표로 장기 투자 전략을 유지하세요."}',
        NOW(), NOW()),
       ('INVEST_LESS', 'FEEDBACK', '전체 자산 중 10~30%를 주식에 투자했을 때, 어떤 피드백을 받을 수 있을까요?',
        '{"assetFeedback": "주식에 대한 투자가 다소 보수적입니다. 추가적인 투자 기회를 탐색할 수 있습니다.", "investFeedback": "안정적인 자산을 유지하며, 성장 가능성이 높은 투자 기회를 찾아보세요."}',
        NOW(), NOW()),
       ('INVEST_TOO_LITTLE', 'FEEDBACK', '전체 자산 중 10% 미만을 주식에 투자했을 때, 어떤 피드백을 받을 수 있을까요?',
        '{"assetFeedback": "주식에 대한 투자가 매우 적습니다. 포트폴리오 다각화와 더 큰 수익을 위한 추가 투자를 고려하세요.", "investFeedback": "저위험 자산과 함께 균형 잡힌 포트폴리오를 구축하세요."}',
        NOW(), NOW()),
       ('NEAR_ZERO_FUNDS', 'FEEDBACK', '자산이 거의 바닥났을 때, 어떻게 해야 할까요?',
        '{"assetFeedback": "자산이 거의 소진되었습니다. 비용 절감과 긴급 자금 조달이 필요합니다.", "investFeedback": "긴급한 상황을 대비해 현금을 확보하고 지출을 최소화하세요."}',
        NOW(), NOW()),
       ('BELOW_ZERO_FUNDS', 'FEEDBACK', '자산이 0원 이하로 떨어졌을 때, 어떻게 해야 할까요?',
        '{"assetFeedback": "자산이 마이너스입니다. 부채 상환을 우선으로 하며, 새로운 수익 창출 방안을 모색하세요.", "investFeedback": "부채를 줄이고, 자산을 보호하기 위한 계획을 수립하세요."}',
        NOW(), NOW()),
       ('INVEST_STABILITY', 'FEEDBACK', '안정적인 투자를 목표로 할 때, 어떻게 해야 할까요?',
        '{"assetFeedback": "안정적인 자산 배분을 유지하며, 장기적인 수익을 기대할 수 있는 전략을 사용하세요.", "investFeedback": "리스크가 낮은 자산에 집중하며, 안정적인 수익을 추구하세요."}',
        NOW(), NOW()),
       ('INVEST_AGGRESSIVELY', 'FEEDBACK', '공격적으로 투자를 할 때, 어떻게 해야 할까요?',
        '{"assetFeedback": "높은 리스크를 감수하고 있습니다. 시장 상황에 맞춰 신속하게 대응할 수 있는 전략이 필요합니다.", "investFeedback": "위험을 분산시키고, 시장 변동성을 잘 관리하세요."}',
        NOW(), NOW()),
       ('INVEST_WITH_CAUTION', 'FEEDBACK', '신중하게 투자를 할 때, 어떻게 해야 할까요?',
        '{"assetFeedback": "리스크를 최소화하고 있습니다. 안정적인 성장을 목표로 투자를 유지하세요.", "investFeedback": "보수적인 접근이 필요하며, 장기적인 안정성을 고려하세요."}',
        NOW(), NOW());

-- monster_collection table example data
INSERT IGNORE INTO monster_collection (user_id, monster_id, created_date, updated_date)
VALUES ('investorking', 'inflation_beast', NOW(), NOW()),
       ('investorking', 'recession_reaper', NOW(), NOW()),
       ('cryptoqueen', 'debt_dragon', NOW(), NOW()),
       ('cryptoqueen', 'stagflation_serpent', NOW(), NOW()),
       ('wallstreetwolf', 'liquidity_trap', NOW(), NOW()),
       ('wallstreetwolf', 'credit_crunch_creeper', NOW(), NOW()),
       ('stockguru', 'deflation_dragon', NOW(), NOW()),
       ('economyexpert', 'housing_bubble_hound', NOW(), NOW()),
       ('marketmaven', 'currency_crisis_cyclops', NOW(), NOW()),
       ('bondboss', 'trade_war_titan', NOW(), NOW());

-- quiz table example data
INSERT IGNORE INTO quiz (quiz_id, theme_id, ai_prompt_id, priority, created_date, updated_date)
VALUES ('depression_reason', 'great_depression', 'depression', 1, NOW(), NOW()),
       ('ww2_economy_change', 'world_war_ii', 'ww2', 2, NOW(), NOW()),
       ('oil_shock_impact', 'oil_shock', 'oil_shock', 3, NOW(), NOW()),
       ('japan_lost_decade', 'lost_decade_japan', 'japan_lost_decade', 4, NOW(), NOW()),
       ('eurozone_impact', 'eurozone', 'eurozone', 5, NOW(), NOW()),
       ('subprime_crisis', 'subprime_crisis', 'subprime_crisis', 6, NOW(), NOW()),
       ('brexit_impact', 'brexit', 'brexit', 7, NOW(), NOW()),
       ('crypto_revolution', 'crypto_revolution', 'crypto_revolution', 8, NOW(), NOW()),
       ('covid19_impact', 'covid19_pandemic', 'covid19', 9, NOW(), NOW()),
       ('asia_market_crash', 'asia_market_crash', 'asia_market_crash', 10, NOW(), NOW());

-- quiz_history table example data
INSERT IGNORE INTO quiz_history (user_id, quiz_id, created_date, updated_date)
VALUES ('investorking', 'depression_reason', NOW(), NOW()),
       ('investorking', 'oil_shock_impact', NOW(), NOW()),
       ('cryptoqueen', 'crypto_revolution', NOW(), NOW()),
       ('cryptoqueen', 'brexit_impact', NOW(), NOW()),
       ('wallstreetwolf', 'subprime_crisis', NOW(), NOW()),
       ('stockguru', 'ww2_economy_change', NOW(), NOW()),
       ('economyexpert', 'japan_lost_decade', NOW(), NOW()),
       ('marketmaven', 'eurozone_impact', NOW(), NOW()),
       ('bondboss', 'covid19_impact', NOW(), NOW()),
       ('forexphenom', 'asia_market_crash', NOW(), NOW());

-- coin table example data
INSERT IGNORE INTO coin (user_id, market, quantity, created_date, updated_date)
VALUES ('investorking', 'btc-krw', 0.5, NOW(), NOW()),
       ('cryptoqueen', 'eth-krw', 10.0, NOW(), NOW()),
       ('wallstreetwolf', 'btc-krw', 1.2, NOW(), NOW()),
       ('stockguru', 'ltc-krw', 25.0, NOW(), NOW()),
       ('economyexpert', 'btc-krw', 0.75, NOW(), NOW()),
       ('marketmaven', 'eth-krw', 15.3, NOW(), NOW()),
       ('bondboss', 'xrp-krw', 5000.0, NOW(), NOW()),
       ('commoditieschamp', 'btc-krw', 0.1, NOW(), NOW()),
       ('derivativesduke', 'ada-krw', 1000.0, NOW(), NOW()),
       ('forexphenom', 'eth-krw', 5.0, NOW(), NOW());
