package uz.data.networkrequest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.data.networkrequest.R
import uz.data.networkrequest.model.Post

class PostAdapter(val posts: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun submitList(newList:ArrayList<Post>){
        posts.clear()
        posts.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post=posts[position]
        if (holder is PostViewHolder){
            holder.apply {
                title.text=post.title
                body.text=post.body
            }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val body = view.findViewById<TextView>(R.id.tvBody)
    }
}