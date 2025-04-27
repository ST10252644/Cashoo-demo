package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R

class ClaimsAdapter (private val claimList: List<ClaimItem>) :
RecyclerView.Adapter<ClaimsAdapter.ClaimViewHolder>() {

    inner class ClaimViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageClaim: ImageView = itemView.findViewById(R.id.ClaimImage)
        val claimTitle: TextView = itemView.findViewById(R.id.ClaimRewardTitle)
        val claimPoints: TextView = itemView.findViewById(R.id.ClaimRewardPoints)

        init {
            // Set the click listener to open the ClaimDetailActivity
            itemView.setOnClickListener {
                val context = itemView.context
                val claim = claimList[adapterPosition]

                val intent = Intent(context, ClaimDetailActivity::class.java)
                // Pass the image resource ID to the new activity
                intent.putExtra("IMAGE_RES_ID", claim.clmImageResId)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaimViewHolder {
        val viewClaim = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reward_claim, parent, false)
        return ClaimViewHolder(viewClaim)
    }

    override fun onBindViewHolder(holder: ClaimViewHolder, position: Int) {
        val claim = claimList[position]
        holder.imageClaim.setImageResource(claim.clmImageResId)
        holder.claimTitle.text = claim.clmTitle
        holder.claimPoints.text = claim.clmPoints
    }

    override fun getItemCount(): Int = claimList.size
}