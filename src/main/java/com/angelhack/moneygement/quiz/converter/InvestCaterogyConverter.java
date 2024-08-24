package com.angelhack.moneygement.quiz.converter;

import com.angelhack.moneygement.ai.dto.InvestCaterogy;
import com.angelhack.moneygement.ai.dto.InvestCaterogy.SubInvestCategory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvestCaterogyConverter {

    private static final String MAJOR_INVEST_CATEGORY = "majorInvestCategory";
    private static final String SUB_INVEST_CATEGORY = "subInvestCategory";
    private static final String FLUCTUATION_RATE = "fluctuationRate";
    private static final String DESCRIPTION = "description";

    public static InvestCaterogy fromJson(String aiAnswerJson) {
        JSONObject aiAnswer = new JSONObject(aiAnswerJson);

        // majorInvestCategory 추출
        JSONArray majorInvestCategoryJson = aiAnswer.getJSONArray(MAJOR_INVEST_CATEGORY);
        List<String> majorInvestCategory = new ArrayList<>();
        for (int i = 0; i < majorInvestCategoryJson.length(); i++) {
            majorInvestCategory.add(majorInvestCategoryJson.getString(i));
        }

        // subInvestCategory 추출
        JSONObject subInvestCategoriesJson = aiAnswer.getJSONObject(SUB_INVEST_CATEGORY);
        Map<String, List<SubInvestCategory>> subInvestCategories = new HashMap<>();

        for (String key : subInvestCategoriesJson.keySet()) {
            JSONArray subCategoriesArray = subInvestCategoriesJson.getJSONArray(key);
            List<SubInvestCategory> subCategoryList = new ArrayList<>();

            for (int i = 0; i < subCategoriesArray.length(); i++) {
                JSONObject subCategoryJson = subCategoriesArray.getJSONObject(i);
                for (String subCategoryName : subCategoryJson.keySet()) {
                    JSONObject details = subCategoryJson.getJSONObject(subCategoryName);
                    SubInvestCategory subInvestCategory = new SubInvestCategory(
                            subCategoryName,
                            details.getBigDecimal(FLUCTUATION_RATE),
                            details.getString(DESCRIPTION)
                    );
                    subCategoryList.add(subInvestCategory);
                }
            }
            subInvestCategories.put(key, subCategoryList);
        }

        return new InvestCaterogy(majorInvestCategory, subInvestCategories);
    }
}
