package com.example.giftsapp.models;

import com.example.giftsapp.R;

import java.util.ArrayList;

public class Category {

    int id ;
    int img ;
    String urlImage;
    String title ;

    public Category() {
    }

    public Category(int id, int img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public Category(int id, String urlImage, String title) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
    }

    public Category( String title,int img) {
        this.title = title;
        this.img = img;
    }

    public Category(int id, String title) {
        this.id=id;
        this.title=title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<Category> getAllGategory(){

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("الأغذية الطازجة",R.drawable.gat ));
        categories.add(new Category( "البقول الجافة و المجمدات",R.drawable.gb  ));
        categories.add(new Category( "المخبوزات و الحلويات",R.drawable.gmkhpozat  ));
        categories.add(new Category("المشروبات و المعلبات",R.drawable.gasma ));
        categories.add(new Category( "الأطعمة الجاهزة",R.drawable.gatjh  ));
        categories.add(new Category("الجزارة و الأسماك",R.drawable.gjz ));
        categories.add(new Category( "الألبان و منتجاتها",R.drawable.gaemnt  ));
        categories.add(new Category("الخضروات و الفاكهة",R.drawable.gkhwfw  ));
        categories.add(new Category("الأجهزة المنزلية",R.drawable.ganwkh ));
        categories.add(new Category("مستلزمات السيارات و المركبات",R.drawable.gmc  ));
        categories.add(new Category("الأدوات الكهربائية",R.drawable.gakh ));
        categories.add(new Category("العدد و الآلات و المهمات",R.drawable.jaal ));
        categories.add(new Category("الكمبيوتر و التكنولوجيا و الهواتف",R.drawable.gkth ));
        categories.add(new Category("الوسائط المتعددة",R.drawable.gwf  ));
        categories.add(new Category("الملابس و المنسوجات",R.drawable.gmn  ));
        categories.add(new Category( "الأثاث المنزلي و المكتبي",R.drawable.gathath  ));
        categories.add(new Category("الستائر و المفروشات",R.drawable.gsm  ));
        categories.add(new Category( "الأحذية و المنتجات الجلدية",R.drawable.gakh  ));
        categories.add(new Category("لعب الأطفال",R.drawable.gaat ));
        categories.add(new Category( "مستحضرات التجميل",R.drawable.gmtj  ));
        categories.add(new Category( "أدوات و مهمات النظافة و الغسيل",R.drawable.ganwkh ));
return categories;
    }
}
