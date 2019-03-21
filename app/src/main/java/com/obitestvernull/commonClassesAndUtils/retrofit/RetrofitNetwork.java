package com.obitestvernull.commonClassesAndUtils.retrofit;

import com.obitestvernull.ActivityVova.fragments.fragmentAkzii.fragment.POJOAkzii.ItemAkzii;
import com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular.Popular;
import com.obitestvernull.CartchkaTovara.fragment.POJO.ItemOfCard;
import com.obitestvernull.commonClassesAndUtils.POJO.CitiesWithStores;
import com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne.FindingProducts;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.categories.CategoriesOfStore;
import com.obitestvernull.thirdModuleCategoriesAndProducts.POJOThirdModule.products.ProductsOfStore;

import java.util.List;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitNetwork {

    @GET("graphql?query=query { cities(has:stores) { id name lat lng mapzoom code stores { id obi_store_id obi_store_id_prepared feed_version name description city_id delivery order_and_take address email work_time rest_time phone auto_map lat lng }} }")
    Call<CitiesWithStores> getCitiesWithStores();

    @GET("graphql")
    Call<CategoriesOfStore> getCategoriesOfStore(@Query("query") String query);

    @GET("graphql")
    Call<ProductsOfStore> getArrayOfProducts(@Query("query") String query, @Query("variables") String variables);

    @GET("graphql")
    Call<FindingProducts> getFindingProducts(@Query("query") String query, @Query("variables") String variables);

    @GET("api/getOffersListWithCities")
    Call<List<ItemAkzii>> getAkziii();

    @GET("api/getGoodsListByStore?store_id=2")
    Call<List<Popular>> getPopular();

    @GET("api/getGoodsListByStoreWithAvailable?store_id=27")
    Call<List<ItemOfCard>>getCartochka();
}
