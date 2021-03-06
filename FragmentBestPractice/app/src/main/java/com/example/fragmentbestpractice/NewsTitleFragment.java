package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitleRecyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(newsAdapter);
        return view;
    }

    public List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for(int i = 1; i <= 50; ++i){
            News news = new News();
            news.setTitle("This is title " + i);
            news.setContent(getRandomLengthContent("This is news content" + i));
            newsList.add(news);
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; ++i){
            builder.append(content);
        }
        return builder.toString();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }
        else{
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTextView;
            public ViewHolder(View view){
                super(view);
                newsTextView = view.findViewById(R.id.news_title);

            }
        }

        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view1){
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.new_content_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    }
                    else{
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position){
            News news = mNewsList.get(position);
            viewHolder.newsTextView.setText(news.getTitle());
        }

        @Override
        public int getItemCount(){
            return mNewsList.size();
        }
    }
}
